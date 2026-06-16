# Garabato 🐢

Intérprete del lenguaje **Logo** implementado en Java desde cero.  
Escribe código Logo y una tortuga virtual dibuja figuras en pantalla en tiempo real.

Desarrollado como proyecto de la materia de **Compiladores** — ESCOM, IPN.

---

## ¿Qué puede dibujar?

| Figura | Figura |
|---|---|
| Polígonos regulares (n=3 al 10) | Curva de Koch (fractal) |
| Estrella de 5 y 6 puntas | Curva de Hilbert |
| Espiral cuadrada | Árbol fractal |
| Espirógrafo | Regla fractal |

---

## Requisitos

Solo necesitas tener **Java 11 o superior** instalado.

- **Windows:** [Descargar Java](https://www.java.com/es/download/)
- **macOS:** `brew install openjdk@11` o [Descargar Java](https://www.java.com/es/download/)
- **Linux:** `sudo apt install default-jdk` (Debian/Ubuntu) o `sudo dnf install java-11-openjdk` (Fedora)

Verifica tu versión:
```bash
java -version
```

---

## Cómo ejecutar

### macOS / Linux
```bash
java -jar Ejecutable_Garabato.jar
```
O con el script incluido:
```bash
./Ejecutar-Garabato.sh
```

### Windows
Doble clic en `Ejecutar-Garabato.bat`  
O desde la terminal:
```cmd
java -jar Ejecutable_Garabato.jar
```

---

## Comandos del lenguaje

| Comando | Descripción |
|---|---|
| `FORWARD[n];` | Avanza n píxeles en la dirección actual |
| `TURN[n];` | Gira n grados |
| `COLOR[R,G,B];` | Cambia el color del trazo |
| `PenUP[];` | Levanta el pincel (mueve sin dibujar) |
| `PenDOWN[];` | Baja el pincel |

### Estructuras de control

```
for(i=0; i<10; i=i+1){ ... }

while(condicion){ ... }

if(condicion){ ... }else{ ... }
```

### Funciones y procedimientos

```
proc nombre(){
    FORWARD[$1];
    TURN[$2];
}
nombre(100, 90);

func calcular(){
    return $1 * 2;
}
```

Los parámetros se acceden con `$1`, `$2`, `$3`...

---

## Ejemplos

### Cuadrado
```
for(i=0; i<4; i=i+1){
    FORWARD[100];
    TURN[90];
}
```

### Triángulo
```
for(i=0; i<3; i=i+1){
    FORWARD[100];
    TURN[120];
}
```

### Espiral cuadrada
```
proc recur(){
    if($1<2){
        FORWARD[$1*10];
    }else{
        FORWARD[$1*10];
        TURN[90];
        recur($1-1);
    }
}
PenUP[];
FORWARD[-350];
TURN[270];
FORWARD[320];
PenDOWN[];
COLOR[251,152,55];
TURN[90];
recur(65);
```

### Curva de Koch (copo de nieve)
```
proc koch(){
    if($1==0){
        FORWARD[$2];
    }else{
        koch($1-1,$2/3);
        TURN[60];
        koch($1-1,$2/3);
        TURN[-120];
        koch($1-1,$2/3);
        TURN[60];
        koch($1-1,$2/3);
    }
}
koch(4,300);
TURN[-120];
koch(4,300);
TURN[-120];
koch(4,300);
```

### Árbol fractal
```
proc arbol(){
    if($1>5){
        FORWARD[$1];
        TURN[20];
        arbol($1-5);
        TURN[320];
        arbol($1-5);
        TURN[20];
        FORWARD[(-1)*($1)];
    }
}
TURN[-90];
FORWARD[200];
COLOR[0,143,57];
TURN[180];
arbol(65);
```

El archivo `Ejemplos de Entradas.txt` incluye todos los ejemplos listos para copiar y pegar.

---

## Compilar desde código fuente

```bash
mkdir build
javac -d build -sourcepath src src/Garabato/Garabato.java src/Vista/*.java src/Compilador/*.java src/Configuracion/*.java
cp -r src/Imgs build/
cd build
jar cfm ../Ejecutable_Garabato.jar ../src/META-INF/MANIFEST.MF .
```

---

## Interfaz

| Botón | Función |
|---|---|
| ▶ Run | Ejecuta todo el código |
| 🗑 Clear | Limpia el panel y el editor |
| 🐛 Debug | Activa modo paso a paso |
| ⏭ Siguiente | Ejecuta la siguiente instrucción (solo en modo debug) |
