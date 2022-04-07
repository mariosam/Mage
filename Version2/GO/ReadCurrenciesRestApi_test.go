/**
 * @version GO
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 * $ go test
 */
package GO

import (
	"reflect"
	"testing"
)

func TestReadCurrenciesRestApi(t *testing.T) {
	tables := []struct {
		site string
		want []string
	}{
		{"https://kriptonita.com.br", []string{"BRL", "USD"}},
		{"https://www.havan.com.br", []string{"BRL"}},
		{"https://www.purplesunrise.com", []string{"GBP"}},
		{"https://truckpartshq.com", []string{"USD"}},
	}

	for _, table := range tables {
		got := getCurrenciesWithREST(table.site)

		if !reflect.DeepEqual(got, table.want) {
			t.Errorf("Waiting for this %v but the return was this: %v", table.want, got)
		}
	}
}
