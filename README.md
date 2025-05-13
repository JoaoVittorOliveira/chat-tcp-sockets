# Chat em Grupo com Java usando TCP e Sockets

## O que é TCP e Sockets?

**TCP (Transmission Control Protocol)** é um protocolo de comunicação confiável usado para transmitir dados entre dois dispositivos na internet ou em uma rede local. Ele garante que os dados cheguem na ordem correta e sem perdas.

**Sockets** são a interface que permite essa comunicação. Um *socket* funciona como um "ponto final" entre duas máquinas conectadas via rede. Com Java, podemos criar programas cliente e servidor que utilizam sockets para trocar mensagens em tempo real.

Neste projeto, usamos sockets TCP para implementar uma aplicação de chat em grupo, onde vários clientes podem se conectar ao servidor e conversar entre si.


# 🗨️ Chat TCP em Grupo com Java

Este projeto é uma aplicação de chat em grupo simples utilizando sockets TCP em Java. Ele permite múltiplos clientes se conectarem simultaneamente a um servidor e trocarem mensagens em tempo real. Pode ser usado localmente (localhost) ou entre máquinas na mesma rede.

---

## 📁 Estrutura do Projeto

- `ChatServer.java`: Código-fonte do servidor.
- `ChatClient.java`: Código-fonte do cliente.
- `README.txt`: Instruções de uso.

---

## 🚀 Como Executar no Localhost (mesma máquina)

1. Compile os arquivos:
   ```bash
   javac ChatServer.java
   javac ChatClient.java
   ```

2. Inicie o servidor:
   ```bash
   java ChatServer
   ```

3. Em outro terminal, inicie um ou mais clientes:
   ```bash
   java ChatClient
   ```

4. Os clientes se conectarão automaticamente ao `localhost` e poderão trocar mensagens entre si.

---

## 🌐 Como Executar em Máquinas Diferentes na Mesma Rede

1. Na máquina **servidora**, execute:
   ```bash
   javac ChatServer.java
   java ChatServer
   ```

2. Descubra o IP da máquina servidora com:
   ```bash
   ip a    (Linux)
   ipconfig (Windows)
   ```

3. Na máquina **cliente**, edite o arquivo `ChatClient.java`:
   ```java
   private static final String SERVER_ADDRESS = "IP_DO_SERVIDOR";
   ```
   Substitua `IP_DO_SERVIDOR` pelo IP obtido no passo anterior.

4. Compile e execute o cliente:
   ```bash
   javac ChatClient.java
   java ChatClient
   ```

---

## 💻 Como Usar no Ubuntu Server

### 1. Instalar o Java

Execute os comandos abaixo no Ubuntu Server:
```bash
sudo apt update
sudo apt install default-jdk -y
```

Verifique a instalação com:
```bash
java -version
```

---

### 2. Transferir o Arquivo `ChatClient.java`

#### Opção 1: Usando scp (a partir do Windows via PowerShell, CMD ou WSL)
```bash
scp ChatClient.java usuario@IP_DO_SERVIDOR:/home/usuario/
```

#### Opção 2: Editando direto no Ubuntu Server
```bash
nano ChatClient.java
```
(Cole o conteúdo do arquivo e salve com `Ctrl+O`, `Enter`, depois `Ctrl+X`)

---

### 3. Compilar e Executar
```bash
javac ChatClient.java
java ChatClient
```

---

## 🛑 Comando para Sair do Chat
Digite `/sair` no cliente para sair do chat de forma limpa.

---

## 📌 Observações

- Todos os clientes conectados ao servidor verão as mensagens em tempo real.
- O servidor precisa estar sempre em execução para que os clientes possam se conectar.
- Certifique-se de que o firewall da máquina servidor permita conexões na porta 12345 (ou altere no código).
- A porta e o IP usados devem ser acessíveis pela rede local.

---
