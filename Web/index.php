<?php
session_start();

include('map.php');
include('include/keys.php');
include('mouvement.php');

if(isset($_GET['mouvement']))
mouvement();

?>

<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Foundation | Welcome</title>
    <link rel="stylesheet" href="css/foundation.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/vendor/modernizr.js"></script>
</head>
<body>
<div class="row"
     style="text-align: center">
    <a href="?mouvement=avancer"
       class="button">
        Avancer
    </a>
    <a href="?mouvement=reculer"
       class="button">
        Reculer
    </a>
    <a href="?mouvement=droite"
       class="button">
        Tourner à droite
    </a>
    <a href="?mouvement=gauche"
       class="button">
        Tourner à gauche
    </a>
    <a href="generer.php"
       class="button">
        Générerer une nouvelle carte
    </a>
    <div class="small-8 medium-8 large-8 columns">
        <div class="panel">
            <table>
                <tr>
                    <th>
                        y\x
                    </th>
                    <?php for ($i = $_SESSION['xRobot'] - 6; $i < $_SESSION['xRobot'] + 6; $i++): ?>
                        <th>
                            <?= $i ?>
                        </th>
                    <?php endfor; ?>
                </tr>
                <?php for ($i = $_SESSION['yRobot'] - 6; $i < $_SESSION['yRobot'] + 6; $i++): ?>
                    <tr>
                        <td>
                            <?= $i ?>
                        </td>
                        <?php for ($j = $_SESSION['xRobot'] - 6; $j < $_SESSION['xRobot'] + 6; $j++): ?>
                            <td style="background-color: <?= caseColor($_SESSION['map'][$j][$i]) ?>"
                                class="robotCase">
                                <?php if ($i == $_SESSION['yRobot'] && $j == $_SESSION['xRobot']):
                                    $_SESSION['map'][$i][$j] ?>
                                    <img src="img/robot.png"
                                         class="robot">
                                <?php endif; ?>
                            </td>
                        <?php endfor; ?>
                    </tr>
                <?php endfor; ?>
            </table>
            <div class="legende"
                 style="background-color: <?= caseColor(1) ?>">
                &nbsp;
            </div>
            Terre
            <div class="legende"
                 style="background-color: <?= caseColor(2) ?>">
                &nbsp;
            </div>
            Roche
            <div class="legende"
                 style="background-color: <?= caseColor(3) ?>">
                &nbsp;
            </div>
            Sable
            <div class="legende"
                 style="background-color: <?= caseColor(4) ?>">
                &nbsp;
            </div>
            Boue
            <div class="legende"
                 style="background-color: <?= caseColor(5) ?>">
                &nbsp;
            </div>
            Infranchissable
        </div>
    </div>
    <div class="small-4 medium-4 large-4 columns">
        <div class="panel">
            <h3>
                Position du robot : (<?= $_SESSION['xRobot'].', '.$_SESSION['yRobot'] ?>)
            </h3>
            <h3>
                Orientation du robot : <?= $_SESSION['orientation'] ?>
            </h3>
        </div>
    </div>
</div>
<?php
//goPageTimer('index.php', 1000);
?>
</body>
</html>
