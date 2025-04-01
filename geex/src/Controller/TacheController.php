<?php

namespace App\Controller;

use App\Entity\Tache;
use App\Form\TacheType;
use App\Repository\TacheRepository;
use Doctrine\ORM\EntityManagerInterface;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class TacheController extends AbstractController
{
    #[Route('/tache', name: 'app_tache_index')]
    public function index(): Response
    {
        return $this->render('tache/index.html.twig', [
            'controller_name' => 'TacheController',
        ]);
    }

    #[Route("/tache/get/all", name: 'app_tache_getall')]
    public function getAllTaches(TacheRepository $repo): Response
    {
        $taches = $repo->findAll();
        return $this->render('tache/list.html.twig', ['taches' => $taches]);
    }

    #[Route('/tache/add', name: 'app_tache_add')]
    public function addTache(EntityManagerInterface $em, Request $req): Response
    {
        $tache = new Tache();
        $form = $this->createForm(TacheType::class, $tache);
        $form->handleRequest($req);

        if ($form->isSubmitted() && $form->isValid()) {
            $em->persist($tache);
            $em->flush();
            return $this->redirectToRoute('app_tache_getall');
        }

        return $this->render('tache/form.html.twig', [
            'form' => $form,
        ]);
    }

    #[Route('/tache/update/{id}', name: 'app_tache_update')]
    public function updateTache(EntityManagerInterface $em, Request $req, int $id, TacheRepository $repo): Response
    {
        $tache = $repo->find($id);
        if (!$tache) {
            throw $this->createNotFoundException('Tâche non trouvée.');
        }

        $form = $this->createForm(TacheType::class, $tache);
        $form->handleRequest($req);

        if ($form->isSubmitted() && $form->isValid()) {
            $em->flush();
            return $this->redirectToRoute('app_tache_getall');
        }

        return $this->render('tache/form.html.twig', [
            'form' => $form,
        ]);
    }

    #[Route('/tache/delete/{id}', name: 'app_tache_delete')]
    public function deleteTache(ManagerRegistry $manager, int $id, TacheRepository $repo): Response
    {
        $tache = $repo->find($id);
        if (!$tache) {
            throw $this->createNotFoundException('Tâche non trouvée.');
        }

        $em = $manager->getManager();
        $em->remove($tache);
        $em->flush();

        return $this->redirectToRoute('app_tache_getall');
    }
}
