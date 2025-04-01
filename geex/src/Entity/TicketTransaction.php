<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * TicketTransaction
 *
 * @ORM\Table(name="ticket_transaction", indexes={@ORM\Index(name="fk_transaction", columns={"transaction_id"})})
 * @ORM\Entity
 */
class TicketTransaction
{
    /**
     * @var int
     *
     * @ORM\Column(name="ticket_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $ticketId;

    /**
     * @var int
     *
     * @ORM\Column(name="transaction_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $transactionId;


}
