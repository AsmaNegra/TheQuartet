<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * FournisseurEvenement
 *
 * @ORM\Table(name="fournisseur_evenement", indexes={@ORM\Index(name="fk_fournisseur_event_evenement", columns={"evenement_id"})})
 * @ORM\Entity
 */
class FournisseurEvenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="fournisseur_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $fournisseurId;

    /**
     * @var int
     *
     * @ORM\Column(name="evenement_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $evenementId;


}
