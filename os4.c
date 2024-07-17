#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define N 5 
#define BROJ_POSJETITELJA 10 

sem_t slobodna_mjesta;
sem_t spreman_za_voznju;
sem_t voznja_zavrsena;

void* posjetitelj(void* arg) {
    int id = *(int*)arg;
    free(arg);

    sem_wait(&slobodna_mjesta); 
    printf("Posjetitelj %d se ukrcava.\n", id);

    sem_post(&spreman_za_voznju); 
    sem_wait(&voznja_zavrsena); 

    printf("Posjetitelj %d silazi.\n", id);

    sem_post(&slobodna_mjesta); 

    return NULL;
}

void* vrtuljak(void* arg) {
    while (1) {
        for (int i = 0; i < N; i++) {
            sem_wait(&spreman_za_voznju);
        }

        printf("Vrtuljak se pokreće...\n");
        sleep(2);
        printf("Vrtuljak se zaustavlja...\n");

        for (int i = 0; i < N; i++) {
            sem_post(&voznja_zavrsena);
        }
    }
    return NULL;
}

int main() {
    pthread_t posjetitelji[BROJ_POSJETITELJA];
    pthread_t dretva_vrtuljka;

    sem_init(&slobodna_mjesta, 0, N);
    sem_init(&spreman_za_voznju, 0, 0);
    sem_init(&voznja_zavrsena, 0, 0);

    pthread_create(&dretva_vrtuljka, NULL, vrtuljak, NULL);

    for (int i = 0; i < BROJ_POSJETITELJA; i++) {
        int* id = malloc(sizeof(int));
        *id = i + 1;
        pthread_create(&posjetitelji[i], NULL, posjetitelj, id);
        sleep(1); 
    }

    for (int i = 0; i < BROJ_POSJETITELJA; i++) {
        pthread_join(posjetitelji[i], NULL);
    }

    pthread_cancel(dretva_vrtuljka);
    pthread_join(dretva_vrtuljka, NULL);

    sem_destroy(&slobodna_mjesta);
    sem_destroy(&spreman_za_voznju);
    sem_destroy(&voznja_zavrsena);

    return 0;
}
