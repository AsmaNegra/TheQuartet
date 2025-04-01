<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Fournisseur
 *
 * @ORM\Table(name="fournisseur")
 * @ORM\Entity
 */
class Fournisseur
{
    /**
     * @var int
     *
     * @ORM\Column(name="fournisseur_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $fournisseurId;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="type_service", type="string", length=255, nullable=false)
     */
    private $typeService;

    /**
     * @var string|null
     *
     * @ORM\Column(name="contrat", type="text", length=65535, nullable=true)
     */
    private $contrat;

    /**
     * @var int
     *
     * @ORM\Column(name="num_tel", type="integer", nullable=false)
     */
    private $numTel;


}
