#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/wait.h>

#define SHMKEY 123456
#define N 2

int *PRAVO;
int *ZASTAVICA;

void udji_u_kriticni_odsjecak(int i, int j) {
    ZASTAVICA[i] = 1;
    while (ZASTAVICA[j]) {
        if (*PRAVO == j) {
            ZASTAVICA[i] = 0;
            while (*PRAVO == j);
            ZASTAVICA[i] = 1;
        }
    }
}
void izadji_iz_kriticnog_odsjecka(int i, int j) {
    *PRAVO = j;
    ZASTAVICA[i] = 0;
}

void proces(int i) {
    for (int k = 1; k <= 5; k++) {
        udji_u_kriticni_odsjecak(i, 1 - i);
        for (int m = 1; m <= 5; m++) {
	printf("(%d, %d, %d)\n", i, k, m);
	sleep(1);
        }
        izadji_iz_kriticnog_odsjecka(i, 1 - i);
    }
}
int main() {

    int shmid;
    void *shmaddr;

    if ((shmid = shmget(SHMKEY, 2 * sizeof(int), IPC_CREAT | 0666)) < 0) {
        perror("shmget");
        exit(1);
    }
    if ((shmaddr = shmat(shmid, NULL, 0)) == (void *) -1) {
        perror("shmat");
        exit(1);
    }
    PRAVO = (int *) shmaddr;
    ZASTAVICA = PRAVO + 1;
    *PRAVO = 0;
    ZASTAVICA[0] = 0;
    ZASTAVICA[1] = 0;
    pid_t pid;

    for (int i = 0; i < N; i++) {
        pid = fork();
        if (pid < 0) {
            perror("fork");
            exit(1);
        } else if (pid == 0) {
            proces(i);
            exit(0);
        }
    }
    for (int i = 0; i < N; i++) {
        wait(NULL);
    }
    if (shmdt(shmaddr) == -1) {
        perror("shmdt");
        exit(1);
    }
    if (shmctl(shmid, IPC_RMID, NULL) == -1) {
        perror("shmctl");
        exit(1);
    }
