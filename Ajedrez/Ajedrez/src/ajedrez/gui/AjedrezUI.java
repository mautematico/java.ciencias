/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.gui;

import ajedrez.juego.*;
import ajedrez.piezas.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
//import ajedrez.RelativeLayout;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author alma
 */
public class AjedrezUI {
    
    private Ajedrez miAjedrez;
    private Posicion posicionInicial;
    private Posicion posicionDestino;
    
    
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "ola ke ase?");
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1, 
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };

    AjedrezUI() {
        initializeGui();
    }

    public final void initializeGui() {
        // create the images for the chess pieces
        createImages();

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action newGameAction = new AbstractAction("Nuevo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setupNewGame();
            }
        };
        tools.add(newGameAction);
        tools.addSeparator();
        tools.addSeparator();
        tools.add(message);

        miAjedrez = new Ajedrez();
        posicionInicial = new Posicion();
        posicionInicial.setPosicion(-1,-1);
        posicionDestino = new Posicion();
        posicionDestino.setPosicion(-1,-1);
        
        gui.add(new JLabel("?"), BorderLayout.LINE_START);

//        chessBoard = new JPanel(new GridLayout(0, 9)) {
        chessBoard = new JPanel() {

            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };

        RelativeLayout rl = new RelativeLayout(RelativeLayout.Y_AXIS);
        rl.setRoundingPolicy( RelativeLayout.FIRST );
        rl.setFill(true);
        chessBoard.setLayout( rl );

        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
                ));
        // Set the BG to be ochre
        Color ochre = new Color(204,119,34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);


        // our chess pieces are 64x64 px in size, so we'll
        // 'fill this in' using a transparent icon..
        ImageIcon icon = new ImageIcon(
                //new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                final int y = Math.abs(i-7);
                final int x = j;
                JButton b = new JButton();
                b.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(posicionInicial.getX() == -1 || posicionInicial.getY() == -1)
                            posicionInicial.setPosicion(x, y);
                        else {
                            posicionDestino.setPosicion(x, y);
                            miAjedrez.moverPieza(miAjedrez.getTablero().getCasillas()[posicionInicial.getX()][posicionInicial.getY()],
                                    miAjedrez.getTablero().getCasillas()[posicionDestino.getX()][posicionDestino.getY()]);
                            System.out.println("Moviendo");
                        }
                        
                        
                        
                    }                
                });
                b.setOpaque(true);
                b.setBorderPainted(false);
                b.setMargin(buttonMargin);
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1)
                        //) {
                        || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[j][i] = b;
            }
        }

        /*
         * fill the chess board
         */

        RelativeLayout topRL = new RelativeLayout(RelativeLayout.X_AXIS);
        topRL.setRoundingPolicy( RelativeLayout.FIRST );
        topRL.setFill(true);
        JPanel top = new JPanel( topRL );
        top.setOpaque(false);
        chessBoard.add(top, new Float(1));

        top.add(new JLabel(""), new Float(1));

        // fill the top row
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER);
            top.add(label, new Float(1));
        }
        // fill the black non-pawn piece row
        for (int i = 0; i < 8; i++) {

            RelativeLayout rowRL = new RelativeLayout(RelativeLayout.X_AXIS);
            rowRL.setRoundingPolicy( RelativeLayout.FIRST );
            rowRL.setFill(true);
            JPanel row = new JPanel( rowRL );
            row.setOpaque(false);
            chessBoard.add(row, new Float(1));

            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        row.add(new JLabel("" + (9-(i + 1)), SwingConstants.CENTER), new Float(1));
                    default:
                        row.add(chessBoardSquares[j][i], new Float(1));
                }
            }
        }
    }

    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    private final void createImages() {
        try {
            InputStream file = getClass().getResourceAsStream("/piezas.png");
            BufferedImage bi = ImageIO.read(file);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 6; j++) {
                    chessPieceImages[i][j] = bi.getSubimage(
                            j * 64, i * 64, 64, 64);
//                            j * 64, i * 64, 48, 48);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Initializes the icons of the initial chess board piece places
     */
    private final void setupNewGame() {
        message.setText("Turno de BLANCAS");
        // set up the black pieces
        for (int i = 0; i < STARTING_ROW.length; i++) {
            chessBoardSquares[i][0].setIcon(new ImageIcon(
                    chessPieceImages[0][STARTING_ROW[i]]));
        }
        for (int i = 0; i < STARTING_ROW.length; i++) {
            chessBoardSquares[i][1].setIcon(new ImageIcon(
                    chessPieceImages[0][PAWN]));
        }
        // set up the white pieces
        for (int i = 0; i < STARTING_ROW.length; i++) {
            chessBoardSquares[i][6].setIcon(new ImageIcon(
                    chessPieceImages[1][PAWN]));
        }
        for (int i = 0; i < STARTING_ROW.length; i++) {
            chessBoardSquares[i][7].setIcon(new ImageIcon(
                    chessPieceImages[1][STARTING_ROW[i]]));
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                AjedrezUI cg = new AjedrezUI();

                JFrame f = new JFrame("Ajedrez");
                f.add(cg.getGui());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
                cg.setupNewGame();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}
