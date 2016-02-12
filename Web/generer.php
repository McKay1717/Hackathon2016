<?php
session_start();

include('map.php');
include('include/keys.php');

session_destroy();

generateMap();


goPage('index.php');