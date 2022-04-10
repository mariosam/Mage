<?php
/**
 * @version PHP
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 * $ ./vendor/bin/phpunit NomeDaClasseTest.php
 */
namespace PHP;

use PHPUnit\Framework\TestCase;
require ("ReadCurrenciesRestApi.php");

class ReadCurrenciesRestApiTest extends TestCase {

    public function testReadCurrenciesRestApi() {
        $obj = new ReadCurrenciesRestApi();
        //Test 1
        $site = "https://kriptonita.com.br";
        $want = ["BRL","USD"];
        $got = $obj->getCurrenciesWithREST( $site );
        $this->assertEquals($want, $got);
        //Test 2
        $site = "https://www.havan.com.br";
        $want = ["BRL"];
        $got = $obj->getCurrenciesWithREST( $site );
        $this->assertEquals($want, $got);
        //Test 3
        $site = "https://www.purplesunrise.com";
        $want = ["GBP"];
        $got = $obj->getCurrenciesWithREST( $site );
        $this->assertEquals($want, $got);
        //Test 4
        $site = "https://truckpartshq.com";
        $want = ["USD"];
        $got = $obj->getCurrenciesWithREST( $site );
        $this->assertEquals($want, $got);
    }

}
