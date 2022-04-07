/**
 * @version GO
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you instead solving web code tests: hire me!
 */
package GO

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
)

/**
 * Simple example of REST API call to return all available currencies of Magento store.
 */
func getCurrenciesWithREST(site string) []string {
	results := make([]string, 0)
	response, _ := http.Get(site + "/rest/V1/directory/currency")

	if response.StatusCode == 200 {
		defer response.Body.Close()
		contents, _ := ioutil.ReadAll(response.Body)

		var obj = make(map[string][]string)
		json.Unmarshal(contents, &obj)

		results = obj["available_currency_codes"]
	}

	return results
}
