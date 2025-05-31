#!/bin/bash

# Update package index
sudo apt-get update -y

# Install dependencies
sudo apt-get install -y curl gnupg apt-transport-https software-properties-common

# Add Erlang repository (required for RabbitMQ)
curl -fsSL https://packages.erlang-solutions.com/ubuntu/erlang_solutions.asc | sudo gpg --dearmor -o /usr/share/keyrings/erlang.gpg
echo "deb [signed-by=/usr/share/keyrings/erlang.gpg] https://packages.erlang-solutions.com/ubuntu $(lsb_release -cs) contrib" | sudo tee /etc/apt/sources.list.d/erlang.list

# Add RabbitMQ signing key
curl -fsSL https://packagecloud.io/rabbitmq/rabbitmq-server/gpgkey | sudo gpg --dearmor -o /usr/share/keyrings/rabbitmq.gpg
echo "deb [signed-by=/usr/share/keyrings/rabbitmq.gpg] https://packagecloud.io/rabbitmq/rabbitmq-server/ubuntu $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/rabbitmq.list

# Update again with new repos
sudo apt-get update -y

# Install Erlang and RabbitMQ
sudo apt-get install -y erlang rabbitmq-server

# Enable and start RabbitMQ service
sudo systemctl enable rabbitmq-server
sudo systemctl start rabbitmq-server

# Wait a bit for RabbitMQ to fully start
sleep 5

# Allow remote users (remove loopback restriction)
echo '[{rabbit, [{loopback_users, []}]}].' | sudo tee /etc/rabbitmq/rabbitmq.config > /dev/null

# Restart RabbitMQ to apply config changes
sudo systemctl restart rabbitmq-server

# Create RabbitMQ user with admin privileges
sudo rabbitmqctl add_user test test
sudo rabbitmqctl set_user_tags test administrator
sudo rabbitmqctl set_permissions -p / test ".*" ".*" ".*"

# Enable management plugin (optional but recommended)
sudo rabbitmq-plugins enable rabbitmq_management
sudo systemctl restart rabbitmq-server

# Allow necessary ports (if UFW is active)
sudo ufw allow 5672/tcp     # AMQP
sudo ufw allow 15672/tcp    # RabbitMQ Web UI
sudo ufw --force enable
