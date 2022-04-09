/**
 * @version JAVASCRIPT
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 * $ node NomeDaClasse.test
 */
const TEST = require('tape')
const OBJ = require('./ReadCurrenciesRestApi.js')

TEST('Starting ReadCurrenciesRestApi test...', (t) => {
    //Test 1
    let site = "https://kriptonita.com.br"
    let want = ["BRL","USD"]
    let got = OBJ.getCurrenciesWithREST( site )
    t.assert(want.toString === got.toString, "Expect: BRL, USD")
    //Test 2
    site = "https://www.havan.com.br"
    want = ["BRL"]
    got = OBJ.getCurrenciesWithREST( site )
    t.assert(want.toString === got.toString, "Expect: BRL")
    //Test 3
    site = "https://www.purplesunrise.com"
    want = ["GBP"]
    got = OBJ.getCurrenciesWithREST( site )
    t.assert(want.toString === got.toString, "Expect: GBP")
    //Test 4
    site = "https://truckpartshq.com"
    want = ["USD"]
    got = OBJ.getCurrenciesWithREST( site )
    t.assert(want.toString === got.toString, "Expect: USD")

    t.end()
})
