/**
 * @version JAVASCRIPT
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 */

//getCurrenciesWithREST('https://kriptonita.com.br');

/**
 * Simple example of REST API call to return all available currencies of Magento store.
 */
function getCurrenciesWithREST(site = "") {
    let result = [];

    const https = require('https');
    const url = `${site}/rest/V1/directory/currency`;
    
    https.get(url, (resp) => {
        let data = '';
        resp.on('data', (chunk) => {
            data += chunk;
        });

        resp.on('end', () => {
            data = JSON.parse(data);

            result = data["available_currency_codes"];
        })
    }).on('error', (err) => {
        console.log('Error: ' + err.message);
    });

    return result;
}
module.exports = {getCurrenciesWithREST}
