#ifndef DENKLEM_COZUCU_H
#define DENKLEM_COZUCU_H

typedef struct {
    double a;
    double b;
    double c;
} DenklemKatsayilari;

typedef struct {
    double kok1;
    double kok2;
} DenklemKokleri;

DenklemKatsayilari dosyadanKatsayilariOku(const char* dosyaAdi);
DenklemKokleri ikinciDerecedenDenklemiCoz(DenklemKatsayilari katsayilar);
void kokleriDosyayaYaz(const char* dosyaAdi, DenklemKokleri kokler);

#endif
