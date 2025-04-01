<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Transaction
 *
 * @ORM\Table(name="transaction", indexes={@ORM\Index(name="utilisateur_id", columns={"utilisateur_id"})})
 * @ORM\Entity
 */
class Transaction
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_transaction", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTransaction;

    /**
     * @var int
     *
     * @ORM\Column(name="utilisateur_id", type="integer", nullable=false)
     */
    private $utilisateurId;

    /**
     * @var float
     *
     * @ORM\Column(name="montant_total", type="float", precision=10, scale=0, nullable=false)
     */
    private $montantTotal;

    /**
     * @var string
     *
     * @ORM\Column(name="mode_paiement", type="string", length=255, nullable=false)
     */
    private $modePaiement;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_paiement", type="datetime", nullable=false)
     */
    private $datePaiement;

    /**
     * @var string
     *
     * @ORM\Column(name="statut", type="string", length=255, nullable=false)
     */
    private $statut;


}
