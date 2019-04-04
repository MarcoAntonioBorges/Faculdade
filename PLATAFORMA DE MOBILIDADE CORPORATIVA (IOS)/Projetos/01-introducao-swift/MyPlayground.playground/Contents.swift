import UIKit

var str = "Hello, playground"
var numero:Int = 10

var numeroNTipado = 20

print(numero)

print(numeroNTipado)

print("A aula de ios é \(numero + numeroNTipado)")

if (numero == numeroNTipado) {
    print("É igual")
} else {
    print("É Diferente")
}


/* TRABALHANDO COM ARRAY E DICIONARIOS */

var shoppingList = ["CatFish", "Water","blue paint","tulips"]

shoppingList[1] = "Bottle water"

var occupation = [
    "MARCO" : "TRABALHADOR",
    "GABRIEL": "VAGABUNDO"
]

for occu in occupation {
    print(occu.key + " é " + occu.value)
}

/*
let notas = [7.0, 8.5, 9.5, 10, 4.5, 6.0, 9.0 , 3.0]

for nota in notas {
    
    
    if(nota > 6){
        print("aprovado!")
    }else{
        print("REPROVADO")
    }
    
}
 */



