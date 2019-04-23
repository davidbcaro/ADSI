using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace BaseDeDatosWarioSoft.Models
{
    public class Project
    {
        [Key]

        public int IdProject { get; set; }
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Código del proyecto")]
        [StringLength(30, ErrorMessage = "El campo {0} puede contener un máximo de {1} y un mínimo de {2} caracteres", MinimumLength = 2)]
        [Index("Project_CodeProject_Index", IsUnique = true)]
        public string CodeProject { get; set; }

        
        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Descripción")]
        public string Description { get; set; }

        [NotMapped]
        [Display(Name = "Codigo-nombre")]
        public string FullName { get { return string.Format("{0} - {1} ", CodeProject, Description); } }

        [Required(ErrorMessage = "Este campo es requerido")]
        [Display(Name = "Estado")]
        public bool State { get; set; }
        public virtual ICollection<Group> Group { get; set; }

    }
    }
