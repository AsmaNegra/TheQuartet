<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Listecategorieevent
 *
 * @ORM\Table(name="listecategorieevent")
 * @ORM\Entity
 */
class Listecategorieevent
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_categorie", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCategorie;

    /**
     * @var string
     *
     * @ORM\Column(name="categorie", type="string", length=255, nullable=false)
     */
    private $categorie;


}
