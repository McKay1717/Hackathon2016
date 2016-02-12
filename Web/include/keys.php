<?php

// Absolute path of this file
$_SESSION['thisPath'] = realpath('.');


// Go to indicate page - NO TIMER
function goPage($url)
{
    echo "
        <script type=text/javascript>window.location.replace('" . $url . "');</script>;
        ";
}


// Go to indicate page  - ON TIMER
function goPageTimer($url, $timer)
{
    echo '
          <script type="text/javascript">window.setTimeout("location=(\'' . $url . '\');",' . $timer . ');</script>
        ';
}