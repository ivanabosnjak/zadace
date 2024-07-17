#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define N 5  

#define RAZMISLJA 0
#define CEKA 1
#define JEDE 2

int stanje[N];
int vilice[N];

pthread_mutex_t monitor;
pthread_cond_t uvjet[N];

void ispisi_stanja() {
    printf("Stanje filozofa: ");
    for (int i = 0; i < N; i++) {
        if (stanje[i] == JEDE) {
            printf("X ");
        } else if (stanje[i] == RAZMISLJA) {
            printf("O ");
        } else {
            printf("o ");
        }
    }
    printf("\n");
}

void jesti(int n) {
    pthread_mutex_lock(&monitor);
    stanje[n] = CEKA;
    ispisi_stanja();

    // Čekanje dok obje vilice nisu slobodne
    while (vilice[n] == 0 || vilice[(n + 1) % N] == 0) {
        pthread_cond_wait(&uvjet[n], &monitor);
    }
    // Uzimanje vilica
    vilice[n] = 0;
    vilice[(n + 1) % N] = 0;
    stanje[n] = JEDE;
    ispisi_stanja();

    pthread_mutex_unlock(&monitor);

    // Simulacija jedenja
    sleep(2);

    pthread_mutex_lock(&monitor);

    // Vraćanje vilica
    vilice[n] = 1;
    vilice[(n + 1) % N] = 1;

    stanje[n] = RAZMISLJA;
    ispisi_stanja();

    // Signalizacija susjedima
    pthread_cond_signal(&uvjet[(n + N - 1) % N]);
    pthread_cond_signal(&uvjet[(n + 1) % N]);

    pthread_mutex_unlock(&monitor);
}

void misliti() {
    sleep(3);
}

void* filozof(void* broj) {
    int i = *(int*)broj;

    while (1) {
        misliti();
        jesti(i);
    }

    return NULL;
}

int main() {
    pthread_t dretva_id[N];
    int broj_filozofa[N];

    pthread_mutex_init(&monitor, NULL);

    for (int i = 0; i < N; i++) {
        pthread_cond_init(&uvjet[i], NULL);
        stanje[i] = RAZMISLJA;
        vilice[i] = 1;  // Sve vilice su na početku slobodne
        broj_filozofa[i] = i;
    }
    for (int i = 0; i < N; i++) {
        pthread_create(&dretva_id[i], NULL, filozof, &broj_filozofa[i]);
    }

    for (int i = 0; i < N; i++) {
        pthread_join(dretva_id[i], NULL);
    }

    pthread_mutex_destroy(&monitor);

    for (int i = 0; i < N; i++) {
        pthread_cond_destroy(&uvjet[i]);
    }
    return 0;
}
