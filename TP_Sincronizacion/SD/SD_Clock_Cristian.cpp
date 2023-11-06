#include <iostream>
#include <chrono>
#include <thread>

using namespace std;

// Función para sincronizar los relojes utilizando el método de Cristian
void synchronizeClocks() {
    // Pedir al usuario que ingrese el tiempo del servidor
    int serverTime;
    cout << "Ingrese el tiempo del servidor: ";
    cin >> serverTime;

    // Obtener el tiempo actual del cliente
    auto clientTime = chrono::system_clock::now();

    // Calcular la diferencia de tiempo entre el cliente y el servidor
    auto timeDifference = chrono::duration_cast<chrono::milliseconds>(clientTime.time_since_epoch()).count() - serverTime;

    // Ajustar el tiempo del cliente
    auto adjustedTime = chrono::system_clock::now() - chrono::milliseconds(timeDifference);

    // Imprimir el tiempo ajustado del cliente
    cout << "El tiempo ajustado del cliente es " << chrono::duration_cast<chrono::milliseconds>(adjustedTime.time_since_epoch()).count() << endl;
}

int main() {
    synchronizeClocks();
    return 0;
}