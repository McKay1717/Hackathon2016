<?php

function caseColor($couleur)
{

    switch ($couleur)
    {
        case 1:
            return '#DFA06F';
        case 2:
            return '#BEAF83';
        case 3:
            return '#FFF2BC';
        case 4:
            return '#470000';
        case 5:
            return '#000000';
    }
}

function generateMap()
{
    session_start();
    $_SESSION['xStartRobot'] = rand(6, 93);
    $_SESSION['yStartRobot'] = rand(6, 93);

    $_SESSION['xRobot'] = $_SESSION['xStartRobot'];
    $_SESSION['yRobot'] = $_SESSION['yStartRobot'];

    for ($i = 0; $i < 100; $i++)
    {
        for ($j = 0; $j < 100; $j++)
        {
            if ($i == $_SESSION['xStartRobot'] && $j == $_SESSION['yStartRobot'])
            {
                $_SESSION['map'][$i][$j] = 1;
            }
            else
            {
                $_SESSION['map'][$i][$j] = rand(1, 5);
            }
        }
    }
    $_SESSION['generate'] = true;
    $_SESSION['orientation'] = 'nord';
}