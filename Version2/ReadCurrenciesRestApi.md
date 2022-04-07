Desafio

Recuperar a lista de moedas habilitadas em uma loja Magento.<br>
Usando REST API para Magento 2.<br>
SEM A NECESSIDADE DE AUTENTICACAO!<br>

Codigo feito nas linguagens: GO, JAVA, Javascript, e PHP.

Entrada

Eh necessario ter um endereco URL valido (uma loja magento)

Saida

{
    "base_currency_code":"USD"
    ,"base_currency_symbol":"$"
    ,"default_display_currency_code":"USD"
    ,"default_display_currency_symbol":"$"
    ,"available_currency_codes":["BRL","USD"]
    ,"exchange_rates":[{"currency_to":"BRL","rate":0},{"currency_to":"USD","rate":1}]
}

No exemplo executado a loja possuia duas moedas, gerando o resultado

[USD, BRL]
