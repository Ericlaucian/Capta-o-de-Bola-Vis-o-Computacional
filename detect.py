import cv2
from ultralytics import YOLO
import socket

host = "127.0.0.1"
port = 5000

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host, port))
server.listen(1)
print(f"Servidor rodando em {host}:{port}, aguardando conexões...")
conn, addr = server.accept()
print(f"Conexão estabelecida com {addr}")

# 1. Carrega o seu modelo
model = YOLO("exp.pt")
# model = YOLO("exp-2.pt")

# 2. Abre a conexão com a webcam (0 é a padrão)
cap = cv2.VideoCapture(0)

while cap.isOpened():
    # Lê um frame da câmera
    success, frame = cap.read()

    if success:
        # Executa a detecção no frame atual
        results = model(frame)

        # Visualiza os resultados no frame
        annotated_frame = results[0].plot()

        # Mostra o frame em uma janela
        cv2.imshow("YOLO26 Detection", annotated_frame)


        for result in results:
            for i, box in enumerate(result.boxes):
                x1, y1, x2, y2 = map(int, box.xyxy[0])
                confidence = float(box.conf[0])
                class_id = int(box.cls[0])
                #print(f"Detecção: Classe {class_id}, Confiança {confidence:.2f}, Caixa ({x1}, {y1}, {x2}, {y2})")
                msg = f"{i}, {x1}, {y1}, {x2}, {y2}, {confidence:.2f}, {class_id}\n"

                conn.send(msg.encode("utf-8"))

        
        # 3. CONDIÇÃO DE PARADA: Fecha se apertar a tecla 'q'
        if cv2.waitKey(1) & 0xFF == ord("q"):
            break
    else:
        break

# 4. LIBERA OS RECURSOS
cap.release()      # Desliga a câmera
cv2.destroyAllWindows() # Fecha todas as janelas do 
conn.close()     # Fecha a conexão do socket
server.close()   # Fecha o servidor
