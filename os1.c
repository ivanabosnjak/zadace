#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <math.h>
#include <signal.h>

#define OBRADA_FILE "obrada.txt"
#define STATUS_FILE "status.txt"

volatile sig_atomic_t broj = 1;

double obrada(int broj) {
    return broj * broj;
}

void handle_sigusr1(int sig) {
    printf("Trenutni broj u obradi: %d\n", broj);
}

void handle_sigterm(int sig) {
    FILE* statusFile = fopen(STATUS_FILE, "w");

    if (statusFile!= NULL) {
        fprintf(statusFile, "%d", broj);
        fclose(statusFile);
        exit(0);
    }
}

void handle_sigint(int sig) {
    FILE* statusFile = fopen(STATUS_FILE, "w");
    if (statusFile!= NULL) {
        fprintf(statusFile, "0");
        fclose(statusFile);
    }
    FILE* obradaFile = fopen(OBRADA_FILE, "r");

    if (obradaFile!= NULL) {
        int zadnjiBroj;
        while (fscanf(obradaFile, "%d", &zadnjiBroj) == 1) {
          broj = sqrt(zadnjiBroj);
        }
        fclose(obradaFile);
    }
    statusFile = fopen(STATUS_FILE, "w");

    if (statusFile!= NULL) {
        fprintf(statusFile, "%d", broj);
       fclose(statusFile);
    }
    exit(0);
}

int main() {
    signal(SIGUSR1, handle_sigusr1);
    signal(SIGTERM, handle_sigterm);
    signal(SIGINT, handle_sigint);

    FILE* obradaFile = fopen(OBRADA_FILE, "a+");
    FILE* statusFile = fopen(STATUS_FILE, "r");

    if (statusFile == NULL) {
        statusFile = fopen(STATUS_FILE, "w");
        fprintf(statusFile, "0");
        fclose(statusFile);
    } else {
        fscanf(statusFile, "%d", &broj);
        fclose(statusFile);
    }
    while (1) {
        double x = obrada(broj);
        fprintf(obradaFile, "%.2f\n", x);
        sleep(5);
        broj++;
    }
    fclose(obradaFile);
    return 0;
}
