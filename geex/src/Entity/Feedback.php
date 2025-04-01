<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Feedback
 *
 * @ORM\Table(name="feedback", indexes={@ORM\Index(name="utilisateur_id", columns={"utilisateur_id"}), @ORM\Index(name="evenement_id", columns={"evenement_id"})})
 * @ORM\Entity
 */
class Feedback
{
    /**
     * @var int
     *
     * @ORM\Column(name="feedback_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $feedbackId;

    /**
     * @var int|null
     *
     * @ORM\Column(name="note", type="integer", nullable=true)
     */
    private $note;

    /**
     * @var string|null
     *
     * @ORM\Column(name="commentaire", type="text", length=65535, nullable=true)
     */
    private $commentaire;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_feedback", type="datetime", nullable=false)
     */
    private $dateFeedback;

    /**
     * @var int|null
     *
     * @ORM\Column(name="evenement_id", type="integer", nullable=true)
     */
    private $evenementId;

    /**
     * @var int|null
     *
     * @ORM\Column(name="utilisateur_id", type="integer", nullable=true)
     */
    private $utilisateurId;


}
