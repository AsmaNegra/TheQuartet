<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * UtilisateurEvenement
 *
 * @ORM\Table(name="utilisateur_evenement")
 * @ORM\Entity
 */
class UtilisateurEvenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="utilisateur_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $utilisateurId;

    /**
     * @var int
     *
     * @ORM\Column(name="evenement_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $evenementId;


}
