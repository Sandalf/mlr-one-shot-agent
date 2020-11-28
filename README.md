
# Hands on 3 - Artificial Intelligence

# How to compile
From root directory run:

```shell
javac -cp lib/jade.jar src/examples/behaviours/*.java -d classes/
```

# How to execute
From root directory run an pass the `x` value as a parameter:
```shell
java -cp lib/jade.jar:classes/ jade.Boot -gui 'oneAgent:examples.behaviours.OneShotAgent(2020)'
```