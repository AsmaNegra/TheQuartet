<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur", uniqueConstraints={@ORM\UniqueConstraint(name="email", columns={"email"})})
 * @ORM\Entity
 */
class Utilisateur
{
    /**
     * @var int
     *
     * @ORM\Column(name="utilisateur_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $utilisateurId;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="mot_de_passe", type="string", length=255, nullable=false)
     */
    private $motDePasse;

    /**
     * @var string
     *
     * @ORM\Column(name="role", type="string", length=255, nullable=false)
     */
    private $role;

    /**
     * @var string|null
     *
     * @ORM\Column(name="etat", type="string", length=255, nullable=true)
     */
    private $etat;

    /**
     * @var int|null
     *
     * @ORM\Column(name="note_organisateur", type="integer", nullable=true)
     */
    private $noteOrganisateur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="entreprise", type="string", length=255, nullable=true)
     */
    private $entreprise;

    /**
     * @var string|null
     *
     * @ORM\Column(name="photo_url", type="string", length=500, nullable=true)
     */
    private $photoUrl;

    /**
     * @var \Doctrine\Common\Collections\Collection
     *
     * @ORM\ManyToMany(targetEntity="Evenement", inversedBy="utilisateur")
     * @ORM\JoinTable(name="evenement_utilisateur",
     *   joinColumns={
     *     @ORM\JoinColumn(name="utilisateur_id", referencedColumnName="utilisateur_id")
     *   },
     *   inverseJoinColumns={
     *     @ORM\JoinColumn(name="evenement_id", referencedColumnName="evenement_id")
     *   }
     * )
     */
    private $evenement = array();

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->evenement = new \Doctrine\Common\Collections\ArrayCollection();
    }

}
