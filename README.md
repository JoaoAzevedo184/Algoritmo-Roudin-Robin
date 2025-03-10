# 📌 Sobre

---

Este projeto implementa o algoritmo de escalonamento **Round Robin** em Java. Ele simula a execução de processos utilizando um quantum definido pelo usuário, garantindo uma distribuição justa do tempo de CPU entre os processos.

## 📂 Estrutura do Projeto

---

```
round_robin_scheduler/
│─── src/
│    ├── Main.java            # Arquivo principal para execução do algoritmo
│    ├── Model/
│    │    ├── ListaProcessos.java  # Gerencia a lista de processos e execução
│    │    ├── Processo.java        # Classe para representar um processo
│─── README.md             # Documentação do projeto
│─── .gitignore            # Arquivos e pastas ignoradas pelo Git
```

## ⚙️ Funcionalidades

---

- Simulação do escalonamento **Round Robin** para processos.
- Definição do quantum pelo usuário.
- Cálculo do tempo médio de espera dos processos.
- Impressão do estado dos processos antes e depois da execução.

## 🛠️ Tecnologias Utilizadas

---

- **Java** - Linguagem de programação principal.
- **IntelliJ IDEA** - Ambiente de desenvolvimento utilizado.
- **Git** - Controle de versão para gerenciamento do código-fonte.

## 🎯 Conceitos Utilizados

---

- **Java Collections** - Utilizado para manipulação da lista de processos.
- **Escalonamento Round Robin** - Técnica de alocação justa de CPU.
- **Scanner e Random** - Entrada de dados e geração de tempos de processos.
- **POO (Programação Orientada a Objetos)** - Classes e encapsulamento.

## 🤝 Contribuição

---

Sinta-se à vontade para contribuir! Para isso:

1. Faça um **fork** do repositório.
2. Crie uma nova branch: `git checkout -b minha-feature`
3. Faça suas alterações e **commit**: `git commit -m 'Adicionando nova funcionalidade'`
4. Envie para o repositório remoto: `git push origin minha-feature`
5. Abra um **Pull Request**.

## 🚀 Como Executar

---

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoaoAzevedo184/Algoritmo-Roudin-Robin.git
   ```
2. Compile os arquivos Java:
   ```bash
   javac src/*.java src/Model/*.java
   ```
3. Execute o programa:
   ```bash
   java src.Main
   ```

## 👤 Autor

---
Desenvolvido por João Azevedo. Para mais informações, entre em contato: 
- **Gmail**: jonoffice37@gmail.com
- **Linkedin**: www.linkedin.com/in/joao-victor-azevedo-181-sena
- **Github**: https://github.com/JoaoAzevedo184