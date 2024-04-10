# sudo docker build -t api_image .
install_docker(){
    echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) INSTALANDO O DOCKER..."
    sleep 2
    echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) ATUALIZANDO PACOTES DA MAQUINA..."
    sleep 1
    sudo apt-get update && sudo apt upgrade -y
    sudo apt install docker.io -y

    sudo systemctl start docker
    sudo systemctl enable docker
    sudo gpasswd -a $USER docker
    # sudo newgrp docker
    echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) DOCKER INSTALADO COM SUCESSO!!"
}

install_docker_compose(){
    echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) INSTALANDO DOCKER COMPOSE..."
    sleep 2
    sudo apt-get install ca-certificates curl gnupg
    sudo apt-get install docker-compose-plugin
    DOCKER_CONFIG=${DOCKER_CONFIG:-$HOME/.docker}
    sudo mkdir -p $DOCKER_CONFIG/cli-plugins
    sudo curl -SL https://github.com/docker/compose/releases/download/v2.17.2/docker-compose-linux-x86_64 -o $DOCKER_CONFIG/cli-plugins/docker-compose
    sudo chmod +x $DOCKER_CONFIG/cli-plugins/docker-compose
    echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) DOCKER COMPOSE INSTALADO"
    docker compose version
}


docker --version
if  [ $? -ne 0 ]
then
    install_docker
fi

docker compose version
if  [ $? -ne 0 ]
then
    install_docker_compose
fi

docker compose up -d
echo  "$(tput setaf 10)[Bot assistant]:$(tput setaf 7) API INICIADA COM SUCESSO!!"