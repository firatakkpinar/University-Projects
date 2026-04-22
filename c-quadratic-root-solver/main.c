#include <stdio.h>
#include "header.h"
#include <math.h>

int main() {
    const char* girdiDosyaAdi = "katsayilar.txt";
    const char* ciktiDosyaAdi = "kokler.txt";

    DenklemKatsayilari katsayilar = dosyadanKatsayilariOku(girdiDosyaAdi);
    DenklemKokleri kokler = ikinciDerecedenDenklemiCoz(katsayilar);
    kokleriDosyayaYaz(ciktiDosyaAdi, kokler);

    printf("Kokler: %lf, %lf\n", kokler.kok1, kokler.kok2);

    return 0;
}

DenklemKatsayilari dosyadanKatsayilariOku(const char* dosyaAdi) {
    FILE* dosya = fopen(dosyaAdi, "r");
    if (dosya == NULL) {
        perror("Dosya açýlamadý");
    }

    DenklemKatsayilari katsayilar;
    fscanf(dosya, "%lf %lf %lf", &katsayilar.a, &katsayilar.b, &katsayilar.c);

    fclose(dosya);
    return katsayilar;
}

DenklemKokleri ikinciDerecedenDenklemiCoz(DenklemKatsayilari katsayilar) {
    DenklemKokleri kokler;
    double delta = katsayilar.b * katsayilar.b - 4 * katsayilar.a * katsayilar.c;

    if (delta >= 0) {
        kokler.kok1 = (-katsayilar.b + sqrt(delta)) / (2 * katsayilar.a);
        kokler.kok2 = (-katsayilar.b - sqrt(delta)) / (2 * katsayilar.a);
    } else {
        kokler.kok1 = kokler.kok2 = NAN;
    }

    return kokler;
}

void kokleriDosyayaYaz(const char* dosyaAdi, DenklemKokleri kokler) {
    FILE* dosya = fopen(dosyaAdi, "w");
    if (dosya == NULL) {
        perror("Dosya açýlamadý");
    }

    fprintf(dosya, "Kok 1: %lf\n", kokler.kok1);
    fprintf(dosya, "Kok 2: %lf\n", kokler.kok2);

    fclose(dosya);
}
