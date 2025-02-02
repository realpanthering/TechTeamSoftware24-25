import SwiftUI
import CoreBluetooth

struct ContentView: View {
    @StateObject private var bluetoothManager = BluetoothManager()

    var body: some View {
        VStack(spacing: 20) {
            Button(action: {
                bluetoothManager.sendCommand("L")
            }) {
                Text("Move Left")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }

            Button(action: {
                bluetoothManager.sendCommand("R")
            }) {
                Text("Move Right")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }

            Button(action: {
                bluetoothManager.sendCommand("U")
            }) {
                Text("Move Up")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }

            Button(action: {
                bluetoothManager.sendCommand("D")
            }) {
                Text("Move Down")
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }

            Button(action: {
                bluetoothManager.sendCommand("F")
            }) {
                Text("Fire")
                    .padding()
                    .background(Color.red)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
