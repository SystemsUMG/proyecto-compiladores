package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
min=[a-z]+
may=[A-Z]+
D=[-]?[0-9]+
NC=[A-Z]+[a-zD]?
cadena = \"[^\"]*\"
comen = "/*"[^\"]*"*/"
operadorLog = ("&&"|"||")+
comilla = \"
menor = "<"
mayor = ">"
igual = "="
distinto = "!"
ter = "?"
imprimirSinSalto = "System.out.print"
imprimirConSalto = "System.out.println"
punto = "."
mas = "+"
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
int {lexeme=yytext(); return Int;}
switch {lexeme=yytext(); return Switch;}
case {lexeme=yytext(); return Case;}
break {lexeme=yytext(); return Break;}
default {lexeme=yytext(); return Default;}
if {lexeme=yytext(); return If;}
else {lexeme=yytext(); return Else;}
while {lexeme=yytext(); return While;}
do {lexeme=yytext(); return Do;}
for {lexeme=yytext(); return For;}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Linea;}
{igual} {lexeme=yytext(); return Igual;}
{menor} {lexeme=yytext(); return Menor;}
{mayor} {lexeme=yytext(); return Mayor;}
{menor}{igual} {lexeme=yytext(); return MenorIgual;}
{mayor}{igual} {lexeme=yytext(); return MayorIgual;}
{igual}{igual} {lexeme=yytext(); return Comparacion;}
{distinto}{igual} {lexeme=yytext(); return Distinto;}
"+" {lexeme=yytext(); return Suma;}
{ter} {lexeme=yytext(); return Ternario;}
"++" {lexeme=yytext(); return Incremento;}
"--" {lexeme=yytext(); return Decremento;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"(" {lexeme=yytext(); return Parentesis_a;}
")" {lexeme=yytext(); return Parentesis_c;}
"{" {lexeme=yytext(); return Llave_a;}
"}" {lexeme=yytext(); return Llave_c;}
"[" {lexeme=yytext(); return Corchete_a;}
"]" {lexeme=yytext(); return Corchete_c;}
":" {lexeme=yytext(); return DosPuntos;}
"main" {lexeme=yytext(); return Main;}
"args" {lexeme=yytext(); return R_args;}
";" {lexeme=yytext(); return P_coma;}
{punto} {lexeme=yytext(); return Punto;}
"package" {lexeme=yytext(); return Paquete;}
"import" {lexeme=yytext(); return Importar;}
"public" {lexeme=yytext(); return Publico;}
"private" {lexeme=yytext(); return Privado;}
"class" {lexeme=yytext(); return Clase;}
"static" {lexeme=yytext(); return Estatico;}
"void" {lexeme=yytext(); return Vacio;}
"String" {lexeme=yytext(); return D_String;}
{min}({min}|{may}|{D})* {lexeme=yytext(); return Identificador;}
{may}({min}|{D})* {lexeme=yytext(); return N_Clase;}
({imprimirSinSalto}|{imprimirConSalto}) {lexeme=yytext(); return Imprimir;}
{D} {lexeme=yytext(); return Numero;}
{cadena} {lexeme=yytext(); return Cadena;}
{comen} {lexeme=yytext(); return Coment;}
{operadorLog} {lexeme=yytext(); return Logicos;}
{D}({min}|{may}|{D})* {lexeme=yytext(); return ERROR;}
 . {return ERROR;}
