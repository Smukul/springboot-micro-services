First Install the Erlang then Rabbit MQ using admin rights

Once you install the RabbitMQ then open the command prompt from sbin dir of rabbitMQ.

run the below command from sbin command prompt -
/>rabbitmq-plugins enable rabbitmq_management

/>rabbitmq-server restart/start

/> rabbitmqctl status

/>rabbitmq-service remove
/>rabbitmq-service install