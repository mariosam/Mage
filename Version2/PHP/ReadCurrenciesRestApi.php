<?php
/**
 * @version PHP
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 */
namespace PHP;

class ReadCurrenciesRestApi {

    /**
     * Simple example of REST API call to return all available currencies of Magento store.
     */
    public function getCurrenciesWithREST( $site = "" ) {
        $results = array();

        try {
            $ch = curl_init( $site . "/rest/V1/directory/currency" );
            curl_setopt( $ch, CURLOPT_CUSTOMREQUEST, "GET" );
            curl_setopt( $ch, CURLOPT_RETURNTRANSFER, true );
                
            $json = curl_exec( $ch );
            $httpcode = curl_getinfo( $ch, CURLINFO_HTTP_CODE );
            curl_close( $ch );

            if ( $httpcode == 200 ) {
                $obj = json_decode( $json );

                $results = $obj->available_currency_codes;
            }
        } catch ( \Exception $e ) {
            echo "Error: " . $e->getMessage();
        }

        return $results;
    }
}
