#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

// Función para sincronizar las computadoras utilizando el algoritmo de Berkeley
void synchronizeComputers() {
    // Vector para almacenar los tiempos de cada computadora
    vector<int> times = {0, 0, 0, 0};

    // Pedir al usuario que ingrese los tiempos de cada computadora
    for (int i = 0; i < 4; i++) {
        
        cout << "Ingrese el tiempo de la computadora " << i + 1 << ": ";
        cin >> times[i];
    }

    // Calcular el tiempo promedio
    int averageTime = accumulate(times.begin(), times.end(), 0) / times.size();

    // Ajustar los tiempos de cada computadora
    for (int i = 0; i < 4; i++) {
        times[i] += averageTime - times[i];
    }

    // Imprimir los tiempos ajustados de cada computadora
    for (int i = 0; i < 4; i++) {
        cout << "El tiempo ajustado de la computadora " << i + 1 << " es " << times[i] << endl;
    }
}

int main() {
    synchronizeComputers();
    return 0;
}