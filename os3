#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define MAX_DRETVI 10

int broj_stolova;
int *stolovi;
int broj_dretvi;
int *ULAZ;
int *BROJ;

void udji_u_kriticni_odsjecak(int i) {
    ULAZ[i] = 1;
    int max = 0;

    for (int j = 0; j < broj_dretvi; j++) {
    if (BROJ[j] > max) {
        max = BROJ[j];
        }
}

    BROJ[i] = max + 1;
    ULAZ[i] = 0;

    for (int j = 0; j < broj_dretvi; j++) {
        while (ULAZ[j]);
        while (BROJ[j] != 0 && (BROJ[j] < BROJ[i] || (BROJ[j] == BROJ[i] && j < i)));
    }
}

void izadji_iz_kriticnog_odsjecka(int i) {
    BROJ[i] = 0;
}

int je_slobodan(int indeks_stola) {
    return stolovi[indeks_stola] == 0;

}
int rezerviraj_stol(int id_dretve, int indeks_stola) {
    if (je_slobodan(indeks_stola)) {
        stolovi[indeks_stola] = id_dretve;
        return 1;
    } else {
        return 0;
    }
}

void prikazi_stanje() {
    for (int i = 0; i < broj_stolova; i++) {
        if (stolovi[i] == 0) {
            printf("-");
        } else {
            printf("%d", stolovi[i]);
        }
    }
    printf("\n");
}

void* funkcija_dretve(void* arg) {
    int id_dretve = *(int*)arg;
    free(arg);

    while (1) {
        sleep(1);
        int indeks_stola = rand() % broj_stolova;
        printf("Dretva %d: odabirem stol %d\n", id_dretve + 1, indeks_stola + 1);
        udji_u_kriticni_odsjecak(id_dretve);

        if (rezerviraj_stol(id_dretve + 1, indeks_stola)) {
            printf("Dretva %d: rezerviram stol %d, stanje: ", id_dretve + 1, indeks_stola + 1);
        } else {
            printf("Dretva %d: neuspjela rezervacija stola %d, stanje: ", id_dretve + 1, indeks_stola + 1);
        }

        prikazi_stanje();
        izadji_iz_kriticnog_odsjecka(id_dretve);
        int svi_rezervirani = 1;

        for (int i = 0; i < broj_stolova; i++) {
            if (je_slobodan(i)) {
                svi_rezervirani = 0;
                break;
            }
        }
        if (svi_rezervirani) {
            break;
        }
    }
    return NULL;
}

int main(int argc, char *argv[]) {

    if (argc != 3) {
        fprintf(stderr, "Upotreba: %s <broj_dretvi> <broj_stolova>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    broj_dretvi = atoi(argv[1]);
    broj_stolova = atoi(argv[2]);

    if (broj_dretvi <= 0 || broj_dretvi > MAX_DRETVI || broj_stolova <= 0) {
        fprintf(stderr, "Neispravan broj dretvi ili stolova\n");
        exit(EXIT_FAILURE);
}

    stolovi = (int*)calloc(broj_stolova, sizeof(int));
    ULAZ = (int*)calloc(broj_dretvi, sizeof(int));
    BROJ = (int*)calloc(broj_dretvi, sizeof(int));

    pthread_t dretve[broj_dretvi];
    srand(time(NULL));

    for (int i = 0; i < broj_dretvi; i++) {
        int *arg = malloc(sizeof(*arg));
        *arg = i;
        pthread_create(&dretve[i], NULL, funkcija_dretve, arg);
    }

    for (int i = 0; i < broj_dretvi; i++) {
        pthread_join(dretve[i], NULL);
    }

    free(stolovi);
    free(ULAZ);
    free(BROJ);
    return 0;

}
