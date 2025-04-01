<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * EventViews
 *
 * @ORM\Table(name="event_views")
 * @ORM\Entity
 */
class EventViews
{
    /**
     * @var int
     *
     * @ORM\Column(name="event_id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $eventId;

    /**
     * @var int|null
     *
     * @ORM\Column(name="view_count", type="integer", nullable=true, options={"default"="1"})
     */
    private $viewCount = 1;


}
