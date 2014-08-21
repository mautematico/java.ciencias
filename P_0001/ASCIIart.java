/*
	v:0.1.9
	Programa que imprimer un --<inserte aquí nombre de la figurita>-- Prometeo a la salida estandar.
		NOTA: Puede ser que quede bastante "estirado", porque está diseñado para visualizarse dentro de un <pre> de HTML.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987
	Facultad de Ciencias.
*/
public class ASCIIart{
	public static void main(String args[]){
/*
	En las siguientes, más o menos 22 líneas, imprimo con println, una a una, las primeras lineas del Prometeo.
*/
		System.out.println("                  .,,,.`           .                                  :+##          ");
		System.out.println("              ;++++'''+++++':`    `';                              .'+####.         ");
		System.out.println("            '+;`          `:'+++',;`,                            ;'#######;         ");
		System.out.println("           +.`                 `:+++';                         ''#########'         ");
		System.out.println("          '   .            ```     ::+++;`                   ;'###########;         ");
		System.out.println("         ;     .     .'+++++++'+++''  '.'++';              :++############`         ");
		System.out.println("         `      . ,++;.        .+'''++',  .;++'.         ,'+##############          ");
		System.out.println("       .''      :+:    :'+++++++';'++:''++;`  ;++;,    `'++###############          ");
		System.out.println("        +;`'   +, , '++:.      `,;++''++' :++#;. ;##: ''++###############`          ");
		System.out.println("        +'.;. +   '+.            `  ;+.;'+++';'+++,`'''+#################           ");
		System.out.println("        ;+;';,: `+`                   '  ` `:+#+##+;''+#################            ");
		System.out.println("        :++;,`:;;                      : ,      `'''++#################,            ");
		System.out.println("        :,++++':.                       .       '''++#################:             ");
		System.out.println("        : ++#+;,,:,                           .''''++################,              ");
		System.out.println("        .. +#'';,.:;                         .''''++################+:              ");
		System.out.println("         ;  ':;;:,,+;'   `                   ''''+++###+++++++#####` `,'#'.         ");
		System.out.println("         '  '.;;;;,,# :',+'                 '''++++#++#++++++++++#                  ");
		System.out.println("         +  ' ;';;;:++`'':+;`               '++++++++++++++++++++`                  ");
		System.out.println("         ',;' ;''';::#+;+:::..,.           `++++++++++++++++++++:                   ");
		System.out.println("         :  '`;'''';;,':::,,:;:;::,,..``   :++++++++++++++++++++                    ");
		System.out.println("         ., ' ;''''';;'+;;++++''''';;;,,..`;+++++++++++++++++++,                    ");
		System.out.println("          ' ; ;'+''';;;#+###++++++++++''';,,.;'+++++++++++++++'                     ");
/*
	En las siguientes, más o menos 22 líneas, imprimo con print (agregando salto de línea manualmente cada vez, una a una, las siguientes lineas del Prometeo.
*/
		System.out.print("          ' : +'''';;:;;###++##++++++++++++'';::'+++++++++++++;                     \n");
		System.out.print("          ' . ''';'++''',   ;#+++++########+++';;+++++++++++''.                     \n");
		System.out.print("          ;```+:;++#+++''+,   `'+++##########++;;'+++++++++'''                      \n");
		System.out.print("          .: ,+ +#++''';+'+`     `'#+########++';;'+++++++''''                      \n");
		System.out.print("           ' '+ '+''';:;:''+        .++#####+++';;+++++++++'''                      \n");
		System.out.print("           ' ++ .+'''';;:;'++         `#####'+++';;+++++++'+':                      \n");
		System.out.print("           ' ++  ''''';;;;'++'.         ,##+''++'';+++++++++'.                      \n");
		System.out.print("           :.'+  '+'''';;:;'++',     :'   .+'''++'':+++++++''`                      \n");
		System.out.print("           .;:+  '++++';;;'++#++,';;;+'.   ''''++'';++++''+''                       \n");
		System.out.print("            +.+  :++++'';;;'+#+'':,,:'##   '+'''++'':+''+++''                       \n");
		System.out.print("            '.+  .+++++'':;;+++++++'';':'  '++''+++';+++'++''                       \n");
		System.out.print("            ' +   '+++++'';;+++'##+''+'++, ,++''+++'''+++''+'                       \n");
		System.out.print("            ,,+   ++++#++'';+#+###++++##+;  +++''+++';+'''+';                       \n");
		System.out.print("            `++.  ;+###+++'''#+#########+#  #++''++++;++'+++,                       \n");
		System.out.print("             +;:   +####++++''+#'#####+'+#  +#+''++++;'++++'                        \n");
		System.out.print("             +.'   +####+++++';,##++++++'' `;'#+'++++'++++''                        \n");
		System.out.print("             ;.+    ###+++';'''',;+''++++` ;;'++''+++'++++'+                        \n");
		System.out.print("             .;+    +##+++';:''+';.;'''''''';';'''''+'++++''                        \n");
		System.out.print("              ++     ###++'';::'+;;.,;;'+++;:;;:''';''+++++'                        \n");
		System.out.print("              ++     +#+++'';:::'';;,.:;;'::::::;'';''++++';                        \n");
		System.out.print("              ++`    +##++''';;;;';;;:,:::::;:,,:;';;;++++':                        \n");
		System.out.print("              ;+,    '###++''';;;;;;;;:::::::;;;::,;;:++++',                        \n");
/*
	Para terminar, imprimo con formato, una a una, las últimas lineas del Prometeo.
*/
		System.out.printf("      %s ;####+'+''';;;''';;;::::..,,::,;:+++'',            %s  \n","        .+'   ","          ");
		System.out.printf("     %s''''';;::;';::::,:;'+++':                        \n","          ++     +###+++'';;;;");
		System.out.printf("            %s''''++'''';;;;;'';::%s   \n","   ++     ++##++++'",":,::+++':                     ");
		System.out.printf("               ++      ##++#%s''';;;'''';;,::                        \n","+++''+++##+'","++++,");
		System.out.printf("               :+       +'+%s++''+''%s'';;;:;;;;;;;;:;+++.                        \n","###","+++");
		System.out.printf("               `+.       '%s###++####+''''''';;;::;:::,',+++`                       %s\n","#"," ");
		System.out.printf("                %s+#####++'##%s                         \n","+:       ,","##++'';;;'+++++;,:;+++");
		System.out.printf("                +'        +########++++'''''''++###+#+,:+++                         \n");
		System.out.printf("                '+        '##########++++++'++++++####+:'++                        `\n");
		System.out.printf("                ,+         %s++++++#######'%s                       ``\n","#####++######+'",":+;");
		System.out.printf("                 +         %s++++++++#++##+                        ``\n","#######","########:+");
		System.out.printf("                 %s'                       %s\n","+    :'++#####################+########'","```");
		System.out.printf("                 +` :;'''+%s%s%s###################+########;                       ```\n","#","#","#");
		System.out.printf("                 %s''''''+##############################:                      ````\n","',","#");
		System.out.printf("                 :''++'%s#####################                 `````\n","''+####","######+    ");
		System.out.printf("                 `++++%s+###                     ````` \n","'''","###################+########+");
		System.out.printf("                  #+++++++######################%s#######'        %s  ``````\n","+#","          ");
		System.out.printf("`                 ##+++++%s+#####################++###+###%s                   ```````\n","+","#");

	}
}
