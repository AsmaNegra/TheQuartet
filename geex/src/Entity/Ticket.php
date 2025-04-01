<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ticket
 *
 * @ORM\Table(name="ticket", indexes={@ORM\Index(name="evenement_id", columns={"evenement_id"})})
 * @ORM\Entity
 */
class Ticket
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_ticket", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTicket;

    /**
     * @var int
     *
     * @ORM\Column(name="evenement_id", type="integer", nullable=false)
     */
    private $evenementId;

    /**
     * @var string
     *
     * @ORM\Column(name="type", type="string", length=255, nullable=false)
     */
    private $type;

    /**
     * @var string
     *
     * @ORM\Column(name="statut", type="string", length=255, nullable=false, options={"default"="'En attente'"})
     */
    private $statut = '\'En attente\'';

    /**
     * @var float
     *
     * @ORM\Column(name="prix", type="float", precision=10, scale=0, nullable=false)
     */
    private $prix;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_validite", type="datetime", nullable=false)
     */
    private $dateValidite;

    /**
     * @var int
     *
     * @ORM\Column(name="nb_tickets", type="integer", nullable=false)
     */
    private $nbTickets;


}
