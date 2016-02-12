<?php

function mouvement()
{
    switch ($_GET['mouvement'])
    {
        case 'avancer':
            avancer();
            break;
        case 'reculer':
            reculer();
            break;
        case 'droite':
            droite();
            break;
        case 'gauche':
            gauche();
            break;
        default:
            goPage('index.php');
            break;
    }

}

function avancer()
{
    switch ($_SESSION['orientation'])
    {
        case 'nord':
            if ($_SESSION['map'][$_SESSION['xRobot']][$_SESSION['yRobot'] - 1] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['yRobot']--;
            }
            break;
        case 'sud':
            if ($_SESSION['map'][$_SESSION['xRobot']][$_SESSION['yRobot'] + 1] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['yRobot']++;
            }
            break;
        case 'est':
            if ($_SESSION['map'][$_SESSION['xRobot'] + 1][$_SESSION['yRobot']] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['xRobot']++;
            }
            break;
        case 'ouest':
            if ($_SESSION['map'][$_SESSION['xRobot'] - 1][$_SESSION['yRobot']] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['xRobot']--;
            }
            break;
        default:
            goPage('accueil.php');
            break;
    }
}

function reculer()
{
    switch ($_SESSION['orientation'])
    {
        case 'nord':
            if ($_SESSION['map'][$_SESSION['xRobot']][$_SESSION['yRobot'] + 1] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['yRobot']++;
            }
            break;
        case 'sud':
            if ($_SESSION['map'][$_SESSION['xRobot']][$_SESSION['yRobot'] - 1] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['yRobot']--;
            }
            break;
        case 'est':
            if ($_SESSION['map'][$_SESSION['xRobot'] - 1][$_SESSION['yRobot']] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['xRobot']--;
            }
            break;
        case 'ouest':
            if ($_SESSION['map'][$_SESSION['xRobot'] + 1][$_SESSION['yRobot']] == 5)
            {
                goPage('index.php');
            }
            else
            {
                $_SESSION['xRobot']++;
            }
            break;
    }
}

function droite()
{
    switch ($_SESSION['orientation'])
    {
        case 'nord':
            $_SESSION['orientation'] = 'est';
            break;
        case 'sud':
            $_SESSION['orientation'] = 'ouest';
            break;
        case 'est':
            $_SESSION['orientation'] = 'sud';
            break;
        case 'ouest':
            $_SESSION['orientation'] = 'nord';
            break;
        default:
            goPage('accueil.php');
            break;
    }
}

function gauche()
{
    switch ($_SESSION['orientation'])
    {
        case 'nord':
            $_SESSION['orientation'] = 'ouest';
            break;
        case 'sud':
            $_SESSION['orientation'] = 'est';
            break;
        case 'est':
            $_SESSION['orientation'] = 'nord';
            break;
        case 'ouest':
            $_SESSION['orientation'] = 'sud';
            break;
    }
}