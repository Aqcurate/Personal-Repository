<?php
function xor_encrypt($in) {
	$key = 'qw8J';
	$text = $in;
	$outText = '';

	for($i=0;$i<strlen($text);$i++){
		$outText .= $text[$i] ^ $key[$i % strlen($key)];
	}

	return $outText;
}

$cookie = base64_encode(xor_encrypt(json_encode(array("showpassword"=>"yes","bgcolor"=>"#ffffff"))));

print $cookie;  
?>    
