# Getting Started

### Documentação
Siga os passos abaixos para rodar o projeto localmente:

* Baixar docker, no caso se não estiver instalado na máquina: [Docker download](https://docs.docker.com/get-docker)

### Comandos
Após dezipar o projeto e abrir em seu editor preferido , executar o comando build do gradle no projeto :

![alt text](https://media.giphy.com/media/YnkMcHgNIMW4Yfmjxr/giphy.gif)

* executar o comando para criar a imagem docker do projeto.
```$xslt
    docker build -t app-spring .
    docker run -p 8080:8080 app-spring
    
    //Se comandos não executarem, rodar os mesmo com sudo, obs: apenas se for rodar em uma máquna linux

    sudo docker build -t app-spring .
    sudo docker run -p 8080:8080 app-spring
```

Link exemplo para testar se subiu o projeto no container docker.

* Link exemplo: [clique aqui http://localhost:8080/{id}/transacoes/{ano}/{mes}](http://localhost:8080/1000/transacoes/2019/01)

