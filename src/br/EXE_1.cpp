#include <stdio.h>
#include <string.h>
#include <stdarg.h>
#include <conio.h>
#include <dos.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>
#include <ctype.h>
#include <locale.h>
#include <math.h>

// MAX STR LEN
#define MAX 500

// Default
void start();
void setColor(int ForgC, int BackC);
void setTextColor(int newcolor);
void setPositionAt(int x, int y);
void printfAt(int x, int y, const char* format, ...);
int end(int ret);

// Program Functions
boolean isPalindromoPerfeito(char *str);
boolean isPalindromo(char *str);
char* strTrim(char *str);
char* toLower(char *str);

// -------------- Program Starts Here ----------------- //
int main(int argc, char **argv)
{
   	start();
   	char str[MAX];
    // Aceita uma String
   	puts("Digite uma Str:");
	gets(str);
	// Verifica se é um pal�ndromo perfeito
	if (isPalindromoPerfeito(str)){
		setPositionAt(5,8);
		printf("A String %s é um palíndromo perfeito!", str);
		return end(0);
	}
	// Verifica se � um palíndromo não perfeito
	if (isPalindromo(str)){
		setPositionAt(5,8);
		printf("A String %s é um palíndromo, mas não é perfeito!", str);
		return end(0);
	}
	printf("A String %s não é merda nenhuma :/", str);
	puts("");
	system("pause");
	return end(0);
}

// -------------- Program Specific Functions ----------------- //
boolean isPalindromoPerfeito(char *str){
	int len = strlen(str);
	int i;
	for (i = 0; i < len; i++){
		if (str[i] != str[len - i - 1]) return 0;
	}
	return 1;
}

boolean isPalindromo(char *str){
	char copyStr[MAX];
	strcpy(copyStr, str);
	strTrim(copyStr);
	return isPalindromoPerfeito(copyStr);
}

char* strTrim(char *str){
	char *copyStr = toLower(str);
	do {
		if (*str != ' ') *copyStr++ = *str;
   	} while (*str++);
   	return strdup(copyStr);
}

char* toLower(char *str){
	char *copyStr = str;
	int i;
   	for(i = 0; copyStr[i]; i++){
  		copyStr[i] = tolower(copyStr[i]);
   	}
	return strdup(copyStr);
}

// -------------- General Functions ----------------- //
void setColor(int ForgC, int BackC){
     WORD wColor = ((BackC & 0x0F) << 4) + (ForgC & 0x0F);;
     SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), wColor);
     return;
}

void setTextColor(int newcolor){
   CONSOLE_SCREEN_BUFFER_INFO csbi;
   GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
   SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),
     (csbi.wAttributes & 0xf0) | newcolor);
}

void setPositionAt(int x, int y) {
  COORD c;
  c.X = x - 1;
  c.Y = y - 1;
  SetConsoleCursorPosition (GetStdHandle(STD_OUTPUT_HANDLE), c);
}

void printfAt(int x, int y, const char* format, ...) {
    setPositionAt(x, y);
    va_list args;
    va_start(args, format);
    while (va_arg(args,int));
    printf(format, args);
    va_end(args);
}

void start(){
	setlocale(LC_ALL, "Portuguese");
	setPositionAt(27,12);
	setTextColor(10);
	printf("Perin.");
	Sleep(1500);
	system("cls");
	setTextColor(15);
}

int end(int ret){
	Sleep(1500);
    system("cls");
    printfAt(20, 20, "Fim do programa...\n");
    Sleep(1000);
    system("pause");
    return ret;
}
