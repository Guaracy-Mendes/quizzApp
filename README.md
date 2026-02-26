# Local startup

## 1. Configuration update

Update the file [application-local.yml](backend/src/main/resources/application-local.yml) to inform: 

- Google and GitHub OAuth2 client credentials
- The secret for signing JWT tokens
- An email address to identify the ADMIN user

## 2. Starting the Database

```sh
cd database/
docker compose up
```

## 3. Backend project start

```sh
cd backend/
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

## 4. Frontend project start

```sh
cd frontend/
npm ci # To download the frontend project dependencies. Only do this the first time.
npm start
```

The project is accessible via the URL: http://localhost:3000

# Getting Started in AWS

## 1. Install Docker
```sh
ssh -i <ec2-ssh-key> ubuntu@<ec2-host>
# Run the get-docker.sh script that can be downloaded from the get.docker.com website.
curl -fsSL https://get.docker.com -o get-docker.sh && sh get-docker.sh

# Add the current user to the docker group to avoid running docker commands with sudo
sudo usermod -aG docker $USER

# Update the current user's groups to avoid having to log in again.
newgrp docker 
```

## 2. Copy the docker-compose.yml and nginx.http.conf files

```sh
scp -i <ec2-ssh-key> aws/docker-compose.yml ubuntu@<ec2-host>:docker-compose.yml
ssh -i <ec2-ssh-key> ubuntu@<ec2-host> "mkdir -p nginx/conf"
scp -i <ec2-ssh-key> aws/nginx.http.conf ubuntu@<ec2-host>:nginx/conf/nginx.http.conf
```

*The **nginx.http.conf** file must be added once our SSL certificate has been generated.*

## 3. Start docker-compose and generate the SSL certificate

```sh
ssh -i <ec2-ssh-key> ubuntu@<ec2-host>
docker compose up -d
docker compose run certbot certonly --webroot --webroot-path /var/www/certbot/ -d quizzapp.xyz
sudo ls -al certbot/conf/live/quizzapp.xyz/
```

## 4. Copy the nginx.https.conf file

```sh
scp -i <ec2-ssh-key> aws/nginx.https.conf ubuntu@<ec2-host>:nginx/conf/nginx.https.conf
```

## 5. Restart docker-compose

```sh
ssh -i <ec2-ssh-key> ubuntu@<ec2-host>
docker compose restart
```

