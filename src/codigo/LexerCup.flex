package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
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
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
int {return new Symbol(sym.Int, yychar, yyline, yytext());}
switch {return new Symbol(sym.Switch, yychar, yyline, yytext());}
case {return new Symbol(sym.Case, yychar, yyline, yytext());}
break {return new Symbol(sym.Break, yychar, yyline, yytext());}
default {return new Symbol(sym.Default, yychar, yyline, yytext());}
if {return new Symbol(sym.If, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
while {return new Symbol(sym.While, yychar, yyline, yytext());}
do {return new Symbol(sym.Do, yychar, yyline, yytext());}
for {return new Symbol(sym.For, yychar, yyline, yytext());}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{igual} {return new Symbol(sym.Igual, yychar, yyline, yytext());}
{menor} {return new Symbol(sym.Menor, yychar, yyline, yytext());}
{mayor} {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
{menor}{igual} {return new Symbol(sym.MenorIgual, yychar, yyline, yytext());}
{mayor}{igual} {return new Symbol(sym.MayorIgual, yychar, yyline, yytext());}
{igual}{igual} {return new Symbol(sym.Comparacion, yychar, yyline, yytext());}
{distinto}{igual} {return new Symbol(sym.Distinto, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
{ter} {return new Symbol(sym.Ternario, yychar, yyline, yytext());}
"++" {return new Symbol(sym.Incremento, yychar, yyline, yytext());}
"--" {return new Symbol(sym.Decremento, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
")" {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
"[" {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
"]" {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}
":" {return new Symbol(sym.DosPuntos, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
"args" {return new Symbol(sym.R_args, yychar, yyline, yytext());}
";" {return new Symbol(sym.P_coma, yychar, yyline, yytext());}
"package" {return new Symbol(sym.Paquete, yychar, yyline, yytext());}
"import" {return new Symbol(sym.Importar, yychar, yyline, yytext());}
"public" {return new Symbol(sym.Publico, yychar, yyline, yytext());}
"private" {return new Symbol(sym.Privado, yychar, yyline, yytext());}
"class" {return new Symbol(sym.Clase, yychar, yyline, yytext());}
"static" {return new Symbol(sym.Estatico, yychar, yyline, yytext());}
"void" {return new Symbol(sym.Vacio, yychar, yyline, yytext());}
"String" {return new Symbol(sym.D_String, yychar, yyline, yytext());}
{punto} {return new Symbol(sym.Punto, yychar, yyline, yytext());}
{min}({min}|{may}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
{may}({min}|{D})* {return new Symbol(sym.N_Clase, yychar, yyline, yytext());}
({imprimirSinSalto}|{imprimirConSalto}) {return new Symbol(sym.Imprimir, yychar, yyline, yytext());}
{D} {return new Symbol(sym.Numero, yychar, yyline, yytext());}
{cadena} {return new Symbol(sym.Cadena, yychar, yyline, yytext());}
{comen} {return new Symbol(sym.Coment, yychar, yyline, yytext());}
{operadorLog} {return new Symbol(sym.Logicos, yychar, yyline, yytext());}
{D}({min}|{may}|{D})* {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
