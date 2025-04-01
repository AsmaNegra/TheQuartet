<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tache
 *
 * @ORM\Table(name="tache", indexes={@ORM\Index(name="evenement_id", columns={"evenement_id"}), @ORM\Index(name="fk_fournisseur_tache", columns={"fournisseur_id"})})
 * @ORM\Entity
 */
class Tache
{
    /**
     * @var int
     *
     * @ORM\Column(name="tache_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $tacheId;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string|null
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=true)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="statut", type="string", length=255, nullable=false)
     */
    private $statut;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_limite", type="datetime", nullable=false)
     */
    private $dateLimite;

    /**
     * @var int|null
     *
     * @ORM\Column(name="evenement_id", type="integer", nullable=true)
     */
    private $evenementId;

    /**
     * @var int|null
     *
     * @ORM\Column(name="fournisseur_id", type="integer", nullable=true)
     */
    private $fournisseurId;

    /**
     * @var string
     *
     * @ORM\Column(name="priorite", type="string", length=255, nullable=false)
     */
    private $priorite;

    /**
     * @var string
     *
     * @ORM\Column(name="user_associe", type="string", length=255, nullable=false)
     */
    private $userAssocie;

    /**
     * @var float|null
     *
     * @ORM\Column(name="budget", type="float", precision=10, scale=0, nullable=true)
     */
    private $budget = '0';


}
