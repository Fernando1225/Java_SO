#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Estructura para representar un evento en el algoritmo de Lamport
struct Event {
    int processId;
    int timestamp;
};

// Función para comparar dos eventos por su timestamp
bool compareEvents(const Event& event1, const Event& event2) {
    if (event1.timestamp == event2.timestamp) {
        return event1.processId < event2.processId;
    }
    return event1.timestamp < event2.timestamp;
}

// Función para sincronizar las computadoras utilizando el algoritmo de Lamport
void synchronizeComputers() {
    // Vector para almacenar los eventos de cada computadora
    vector<Event> events;

    // Agregar los eventos iniciales de cada computadora
    events.push_back({1, 0});
    events.push_back({2, 0});
    events.push_back({3, 0});
    events.push_back({4, 0});

    // Ordenar los eventos por su timestamp
    sort(events.begin(), events.end(), compareEvents);

    // Imprimir el orden de ejecución de los procesos
    for (const auto& event : events) {
        cout << "Proceso P" << event.processId << " ejecutado en el tiempo " << event.timestamp << endl;
    }
}

int main() {
    synchronizeComputers();
    return 0;
}